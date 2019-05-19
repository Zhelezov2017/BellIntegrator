package ru.mithril.demo.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mithril.demo.view.operations.office.ListOffice;
import ru.mithril.demo.view.operations.office.SaveOffice;
import ru.mithril.demo.view.operations.office.UpdateOffice;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Офис")
@Data
@AllArgsConstructor
public class OfficeView {

    @NotNull(groups = UpdateOffice.class)
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true)
    public Long id;

    @NotNull(groups = UpdateOffice.class)
    @Size(max = 50)
    @ApiModelProperty(value = "Название")
    public String name;

    @NotNull(groups = UpdateOffice.class)
    @Size(max = 50)
    @ApiModelProperty(value = "Адрес")
    public String address;

    @Size(max = 50)
    @ApiModelProperty(value = "Телефон")
    public String phone;

    @NotNull
    @JsonProperty("isActive")
    @ApiModelProperty(value = "Активен или нет")
    public Boolean isActive;

    @NotNull(groups = {ListOffice.class, SaveOffice.class})
    @ApiModelProperty(value = "Id организации")
    public String orgId;

    public OfficeView(Long id, String name, String address, String phone, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public OfficeView(String name, String address, String phone, Boolean isActive, String orgId) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
        this.orgId = orgId;
    }

    public OfficeView(String name, String phone, Boolean isActive, String orgId) {
        this.name = name;
        this.phone = phone;
        this.isActive = isActive;
        this.orgId = orgId;
    }
}
