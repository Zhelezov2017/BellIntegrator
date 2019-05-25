package ru.mithril.demo.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;

@ApiModel(description = "Документ")
@Data
@AllArgsConstructor
public class DocumentView {

    @Size(max = 50)
    @ApiModelProperty(value = "Название документа")
    private String name;

    @Size(max = 50)
    @ApiModelProperty(value = "Код документа")
    private String code;
}
