package com.itspace.kinogospringrest.validation;

import com.itspace.kinogospringcommon.exception.InvalidPicException;
import com.itspace.kinogospringcommon.model.entity.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * The {@code PicValidator} class wraps for validate picture extension
 * and size
 *
 * @author  Maksim Aslanyan
 * version   1
 */

@Component
@Slf4j
public class PicValidator {

    private final String PNG_CONTENT_TYPE = "pic/png";

    public void validatePic(MultipartFile multipartFile) {
        validatePicSize(multipartFile);
        validateFileExtension(multipartFile);
    }

    private void validatePicSize(MultipartFile file) {
        long size = file.getSize();
        if (size < 1000000 || size > 4000000) {

            throw new InvalidPicException();
        }
    }

    private void validateFileExtension(MultipartFile file) {
        String extension = file.getContentType();

        if (!PNG_CONTENT_TYPE.equals(extension)) {
            throw new InvalidPicException();
        }
    }
}

