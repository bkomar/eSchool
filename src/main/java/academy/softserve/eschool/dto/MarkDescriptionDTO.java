package academy.softserve.eschool.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class MarkDescriptionDTO {
    @ApiModelProperty(notes = "mark value")
    private Byte mark;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy.MM.dd")
    @ApiModelProperty(notes = "date of mark")
    private Date dateMark;
    @ApiModelProperty(notes = "type of mark")
    private String typeMark;

}
