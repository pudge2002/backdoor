package com.example.backdoor.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import com.example.backdoor.model.*;

import com.example.backdoor.repos.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.awt.*;
import java.util.Collection;

@PageTitle("Список продуктов")
@Route("")
@Menu(order = 0, icon = "line-awesome/svg/pencil-ruler-solid.svg")
@Uses(Icon.class)
public class HomeView extends Composite<VerticalLayout> {

    private final PropertyValueRepository propertyValueRepository;
    private final RoleRepository roleRepository;

    public HomeView(PropertyValueRepository propertyValueRepository, RoleRepository roleRepository) {
        this.propertyValueRepository = propertyValueRepository;
        this.roleRepository = roleRepository;
        FormLayout formLayout2Col = new FormLayout();

        Grid<PropertyValue> basicGrid = new Grid<>(PropertyValue.class);
        //<theme-editor-local-classname>
        basicGrid.addClassName("home-view-grid-1");
        Grid<Role> basicGrid2 = new Grid<>(Role.class);
        //<theme-editor-local-classname>
        basicGrid2.addClassName("home-view-grid-2");

        HorizontalLayout layoutRow = new HorizontalLayout();
        //<theme-editor-local-classname>
        layoutRow.addClassName("home-view-horizontal-layout-1");
        Button buttonPrimary = new Button();
        //<theme-editor-local-classname>
        buttonPrimary.addClassName("home-view-button-1");
        Button buttonPrimary2 = new Button();
        //<theme-editor-local-classname>
        buttonPrimary2.addClassName("home-view-button-2");
        Button buttonPrimary3 = new Button();
        //<theme-editor-local-classname>
        buttonPrimary3.addClassName("home-view-button-3");
        Button buttonPrimary4 = new Button();
        //<theme-editor-local-classname>
        buttonPrimary4.addClassName("home-view-button-4");
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        //<theme-editor-local-classname>
        layoutRow2.addClassName("home-view-horizontal-layout-2");
        Button buttonPrimary5 = new Button();
        //<theme-editor-local-classname>
        buttonPrimary5.addClassName("home-view-button-5");
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        formLayout2Col.setWidth("100%");
        H2 header = new H2("Список продуктов");
        H2 grid1Header = new H2("Список ролей");
        //<theme-editor-local-classname>
        grid1Header.addClassName("home-view-h2-1");
        basicGrid.setWidth("1000px");
        basicGrid.getStyle().set("flex-grow", "0");
        setGridSampleData_product(basicGrid);
        basicGrid2.setWidth("250px");
        basicGrid2.getStyle().set("flex-grow", "0");
        setGridSampleData_roles(basicGrid2);
        layoutRow.setHeightFull();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        buttonPrimary.setText("Добавить");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("Открыть");
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary3.setText("Настройки");
        buttonPrimary3.setWidth("min-content");
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary4.setText("Редактирование");
        buttonPrimary4.setWidth("min-content");
        buttonPrimary4.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutRow2.setHeightFull();
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        buttonPrimary5.setText("Выбрать роль");
        buttonPrimary5.setWidth("min-content");
        buttonPrimary5.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(formLayout2Col);

        formLayout2Col.add( header, grid1Header, basicGrid, basicGrid2, layoutRow);

        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonPrimary2);
        layoutRow.add(buttonPrimary3);
        layoutRow.add(buttonPrimary4);
        formLayout2Col.add(layoutRow2);
        layoutRow2.add(buttonPrimary5);
        buttonPrimary2.addClickListener(event -> {
            PropertyValue selectedItem = basicGrid.asSingleSelect().getValue();
            if (selectedItem != null) {
                System.out.println("Выбранный элемент: " + selectedItem);
            } else {
                System.out.println("Ничего не выбрано");
            }
        });
    }

    private void setGridSampleData_product(Grid grid) {
        grid.setItems(propertyValueRepository.findAll());
    }

    private void setGridSampleData_roles(Grid grid) {
        grid.setItems(roleRepository.findAll());
    }

}
