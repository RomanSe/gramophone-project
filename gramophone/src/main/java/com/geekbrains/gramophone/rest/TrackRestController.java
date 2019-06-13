package com.geekbrains.gramophone.rest;

import com.geekbrains.gramophone.entities.User;
import com.geekbrains.gramophone.services.TrackService;
import com.geekbrains.gramophone.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/")
@Api(tags = "Track")
public class TrackRestController {

    @Autowired
    UserService userService;

    @Autowired
    TrackService trackService;

    @PostMapping("track/{id}/like")
    public ResponseEntity<?> like(@ApiParam(value = "Track id", example = "1")
                                  @PathVariable Long id,
                                  @ApiParam(value = "User id", example = "2")
                                  @RequestParam Long userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isPresent()) {
            trackService.changeLike(id, user.get());
        } else {
            return new ResponseEntity<>(null, null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(null, null, HttpStatus.OK);
    }
}
