package java5.exam4;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.IOException;

@ToString
@Getter
@RequiredArgsConstructor
public class ReturnErrorCode  {
    private final int code;
    private final String msg;

}
