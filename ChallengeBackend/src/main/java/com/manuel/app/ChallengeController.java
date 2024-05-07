package com.manuel.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenges")
@CrossOrigin(origins = "http://localhost:3000")
public class ChallengeController {

    private  ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService){
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallenge(){
        return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }
    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(@PathVariable String month){
        Challenge challenge = challengeService.getChallenge(month);
        if (challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge){
        boolean isCHallengeAdded =
                challengeService.addChallenge(challenge);
        if (isCHallengeAdded) {
            return new ResponseEntity<>("Challenge added successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge not added successfully",HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody Challenge updatedChallenge){
       boolean isChallengeUpdated =  challengeService.updateChallenge(id, updatedChallenge);

        if (isChallengeUpdated) {
            return new ResponseEntity<>("Challenge updated successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge not updated successfully",HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isChallengeDeleted = challengeService.deleteChallenge(id);

        if (isChallengeDeleted) {
            return new ResponseEntity<>("Challenge removed successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge not removed successfully",HttpStatus.NOT_FOUND);
        }

    }
}
