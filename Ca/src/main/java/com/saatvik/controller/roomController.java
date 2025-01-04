package com.saatvik.controller;

import com.saatvik.entities.Room;
import com.saatvik.repository.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/rooms")
public class roomController {

    RoomRepository roomRepository;
//    constructor injection
    public roomController(RoomRepository roomRepository){
        this.roomRepository =  roomRepository;
    }

    //    Todo create new room
    @PostMapping
    public ResponseEntity<?> craeteRoom(@RequestBody String roomId){
        Room room = roomRepository.findByRoomId(roomId);
        if(room != null){
            return  ResponseEntity.badRequest().body("Room already exists");
        }
        Room room1 = new Room();
        room1.setRoomId(roomId);
        roomRepository.save(room1);
        return  ResponseEntity.status(HttpStatus.CREATED).body(room);
    }
    //     Todo join room

    //    Todo save room

}
