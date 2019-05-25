package ru.mithril.demo.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Size;

@ApiModel(description = "Страна")
@Data
@AllArgsConstructor
public class CountryView {

    @Size(max = 50)
    @ApiModelProperty(value = "Название страны")
    private String name;

    @Size(max = 50)
    @ApiModelProperty(value = "Код страны")
    private String code;

}
