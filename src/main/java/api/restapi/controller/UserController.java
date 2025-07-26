package api.restapi.controller;


import api.restapi.api.response.WheatherResponse;
import api.restapi.entity.JournalEntry;
import api.restapi.entity.User;
import api.restapi.repository.UserRepository;
import api.restapi.service.JournalEntryService;
import api.restapi.service.UserService;
import api.restapi.service.WheatherService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WheatherService wheatherService;


    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        User userInDb = userService.findByUserName(userName);
        if (userInDb != null) {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveNewUser(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUserById() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(auth.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{city}")
    public ResponseEntity<String> getWheather(@PathVariable String city) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        // Get weather data
        WheatherResponse response = wheatherService.getWeather(city);
        WheatherResponse.Current current = response.getCurrent();

        // Build response message
        String message = String.format(
                "hii %s, your city %s weather is %d°C with %s",
                auth.getName(),
                city,
                current.getTemperature(),
                String.join(", ", current.getWeatherDescriptions())
        );

        return ResponseEntity.ok(message);
    }






}
