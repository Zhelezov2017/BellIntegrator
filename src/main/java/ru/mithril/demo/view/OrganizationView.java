package ru.mithril.demo.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.mithril.demo.view.operations.organization.ListOrganization;
import ru.mithril.demo.view.operations.organization.SaveOrganization;
import ru.mithril.demo.view.operations.organization.UpdateOrganization;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(description = "Организация")
@Data
@AllArgsConstructor
public class OrganizationView {

    @NotNull(groups = UpdateOrganization.class)
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true)
    public Long id;


    @NotNull(groups = {UpdateOrganization.class, ListOrganization.class, SaveOrganization.class})
    @Size(max = 50)
    @ApiModelProperty(value = "Название")
    public String name;

    @NotNull(groups = {UpdateOrganization.class, SaveOrganization.class})
    @Size(max = 50)
    @ApiModelProperty(value = "Полное название")
    public String fullName;

    @NotNull(groups = {UpdateOrganization.class, SaveOrganization.class})
    @Size(max = 50)
    @ApiModelProperty(value = "ИНН")
    public String inn;

    @NotNull(groups = {UpdateOrganization.class, SaveOrganization.class})
    @Size(max = 50)
    @ApiModelProperty(value = "КПП")
    public String kpp;

    @NotNull(groups = {UpdateOrganization.class, SaveOrganization.class})
    @Size(max = 50)
    @ApiModelProperty(value = "Адрес")
    public String address;

    @Size(max = 50)
    @ApiModelProperty(value = "Телефон")
    public String phone;

    @JsonProperty("isActive")
    @ApiModelProperty(value = "Активен или нет")
    public Boolean isActive;

    public OrganizationView(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
}
