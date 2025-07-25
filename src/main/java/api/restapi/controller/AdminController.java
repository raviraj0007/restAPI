package api.restapi.controller;


import api.restapi.cache.AppCache;
import api.restapi.entity.User;
import api.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = {
        "http://localhost:3000",
        "https://journalentry-1.netlify.app"
})

@RestController
@RequestMapping("/admin")

public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private AppCache appCache;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all-users")
    public ResponseEntity<?> getAllusers() {
        List<User> All = userService.getAll();
        if(All != null && !All.isEmpty()) {
            return ResponseEntity.ok(All);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create-admin-user")
    public void createAdmin(User user) {
        userService.saveAdmin(user);
    }

    @GetMapping("/clear-app-cache")
    public void clearAppCache() {
        appCache.init();
    }
}
