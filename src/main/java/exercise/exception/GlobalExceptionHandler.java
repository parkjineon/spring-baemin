package exercise.exception;

import com.example.mall.utils.ApiUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

import static com.example.mall.utils.ApiUtils.error;

@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ApiUtils.ApiResult<Map<String,String>> handleValidationExceptions(MethodArgumentNotValidException errors){
        Map<String, String> errorMessages = new HashMap<>();

        for(FieldError error: errors.getFieldErrors()){
            String errorField = error.getField(); // 예외 field
            String errorMessage = error.getDefaultMessage();// 예외 message
            errorMessages.put(errorField,errorMessage);
        }

        log.info("errorMessage = {}", errorMessages.toString());

        return error(errorMessages, HttpStatus.BAD_REQUEST);
    }

}
