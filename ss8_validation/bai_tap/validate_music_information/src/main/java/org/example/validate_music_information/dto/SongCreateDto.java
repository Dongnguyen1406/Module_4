package org.example.validate_music_information.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SongCreateDto {
    
    @NotBlank(message = "Tên bài hát không để trống!")
    @Size(max = 800, message = "Không quá 800 kí tự")
    @Pattern(regexp = "^[a-zA-ZÀ-ỹ0-9 ]{1,800}$",message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String name;

    @NotBlank(message = "Tên nghệ sĩ không để trống!")
    @Size(max = 300, message = "Không quá 300 kí tự")
    @Pattern(regexp = "^[a-zA-ZÀ-ỹ0-9 ]{1,300}$" ,message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String artistName;

    @NotBlank(message = "Thể loại nhạc không để trống!")
    @Size(max = 1000, message = "Không quá 1000 kí tự")
    @Pattern(regexp = "^[a-zA-ZÀ-ỹ0-9 ,]{1,1000}$", message = "Ngoại trừ dấu phẩy “,” , các ký tự đặc biệt còn lại không được")
    private String musicGenre;
}
