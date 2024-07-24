package com.example.validate_inf_music.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SongDTO {
    @NotBlank(message = "Tên không được để trống!")
    @Size(max = 800, message = "Tên không được quá 800 kí tự!")
    @Pattern(regexp = "^[a-zA-ZàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬđĐèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆìÌỉỈĩĨíÍịỊòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰỳỲỷỶỹỸýÝỵỴ ]+$",
    message = "Tên không hợp lệ!")
    private String name;
    @NotBlank(message = "Tên ca sĩ không được để trống!")
    @Size(max = 300, message = "Tên ca sĩ không được quá 300 kí tự!")
    @Pattern(regexp = "^[a-zA-ZàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬđĐèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆìÌỉỈĩĨíÍịỊòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰỳỲỷỶỹỸýÝỵỴ ]+$",
            message = "Tên Ca sĩ không hợp lệ!")
    private String singer;
    @NotBlank(message = "Tên ca sĩ không được để trống!")
    @Size(max = 1000, message = "Tên ca sĩ không được quá 1000 kí tự!")
    @Pattern(regexp = "^[0-9a-zA-ZàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬđĐèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆìÌỉỈĩĨíÍịỊòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰỳỲỷỶỹỸýÝỵỴ ]+$",
            message = "Tên thể loại không hợp lệ!")
    private String genre;
}
