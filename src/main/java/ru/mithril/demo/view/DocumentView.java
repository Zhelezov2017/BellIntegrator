package ru.mithril.demo.view;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

public class DocumentView {

    @Size(max = 50)
    @ApiModelProperty(value = "Название документа")
    private String name;

    @Size(max = 50)
    @ApiModelProperty(value = "Код документа")
    private String code;
}
