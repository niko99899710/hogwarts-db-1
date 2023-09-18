package pro.sky.hogwartsdb.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pro.sky.hogwartsdb.model.Avatar;
import pro.sky.hogwartsdb.service.AvatarService;

import java.awt.*;
import java.io.IOException;

@RestController
@RequestMapping("avatar")
public class AvatarController {
    public final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @PostMapping(value = "/{student}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadAvatar (@PathVariable Long studentId, @RequestParam MultipartFile avatarFile) throws IOException{
        avatarService.uploadAvatar(studentId, avatarFile);
        return  ResponseEntity.ok().build();
    }

    public ResponseEntity <byte[]> downloadAvatar (@PathVariable Long avatarId) {
        Avatar avatar = avatarService.findAvatar(avatarId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
        headers.setContentLength(avatar.getData().length);
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(avatar.getData());
    }

}
