package com.itspace.kinogospringrest.validation;

import com.itspace.kinogospringcommon.exception.InvalidVideoException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import static com.itspace.kinogospringcommon.exception.ErrorHandler.INVALID_IMAGE_SIZE;

/**
 * The {@code MovieVideoValidator} class wraps for validate video extension
 * and size
 *
 * @author  Maksim Aslanyan
 * version   1
 */

@Component
public class MovieVideoValidator {

    private static final String MP4_CONTENT_TYPE = "video/m4";


    public void validateMovieVideo(MultipartFile multipartFile) {
        validateMovieFileExtension(multipartFile);
        validateMovieFileSize(multipartFile);
    }


    private void validateMovieFileSize(MultipartFile multipartFile) {
        long size = multipartFile.getSize();
        if (size < 1000000 || size > 5000000) {
            throw new InvalidVideoException(INVALID_IMAGE_SIZE);
        }
    }

    private void validateMovieFileExtension(MultipartFile multipartFile) {
        String extension = multipartFile.getContentType();
        if (!MP4_CONTENT_TYPE.equals(extension)) {

            throw new InvalidVideoException(INVALID_IMAGE_SIZE);
        }
    }
}
