package ru.mithril.demo.view;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mithril.demo.view.operations.user.ListUser;
import ru.mithril.demo.view.operations.user.SaveUser;
import ru.mithril.demo.view.operations.user.UpdateUser;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Пользователь")
@Data
@AllArgsConstructor
public class UserView {

    @NotNull(groups = UpdateUser.class)
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true)
    public Long id;

    @NotNull(groups = {UpdateUser.class, SaveUser.class})
    @Size(max = 50)
    @ApiModelProperty(value = "Имя")
    public String firstName;

    @Size(max = 50)
    @ApiModelProperty(value = "Фамилия")
    public String secondName;

    @Size(max = 50)
    @ApiModelProperty(value = "Отчество")
    public String middleName;

    @NotNull(message = "position cannot be null", groups = {UpdateUser.class, SaveUser.class})
    @Size(max = 50)
    @ApiModelProperty(value = "Должность")
    public String position;

    @NotNull(groups = {ListUser.class, SaveUser.class})
    @ApiModelProperty(value = "Офис")
    public Integer officeId;

    @Size(max = 50)
    @ApiModelProperty(value = "Телефон")
    public String phone;

    @Size(max = 50)
    @ApiModelProperty(value = "Код документа")
    public String docCode;

    @Size(max = 50)
    @ApiModelProperty(value = "Имя документа")
    public String docName;

    @Size(max = 50)
    @ApiModelProperty(value = "Номер документа")
    public String docNumber;

    @ApiModelProperty(value = "Дата документа")
    public String docDate;

    @Size(max = 50)
    @ApiModelProperty(value = "Городское имя")
    public String citizenShipName;

    @Size(max = 50)
    @ApiModelProperty(value = "Городской код")
    public String citizenShipCode;

    @JsonProperty("isIdentified")
    @ApiModelProperty(value = "Включен или нет")
    public Boolean isIdentified;


    public UserView(String firstName, String middleName, String position, Integer officeId, String citizenShipCode, String secondName, String docCode) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
        this.officeId = officeId;
        this.docCode = docCode;
        this.citizenShipCode = citizenShipCode;
    }


    public UserView(Long id,  String firstName, String position, Integer officeId,
                    String secondName,  String middleName) {
        this.id = id;
        this.firstName = firstName;
        this.position = position;
        this.officeId = officeId;
        this.secondName = secondName;
        this.middleName = middleName;
    }
}
