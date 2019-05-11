package ru.mithril.demo.view;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

public class CountryView {

    @Size(max = 50)
    @ApiModelProperty(value = "Название страны")
    private String name;

    @Size(max = 50)
    @ApiModelProperty(value = "Код страны")
    private String code;

}
