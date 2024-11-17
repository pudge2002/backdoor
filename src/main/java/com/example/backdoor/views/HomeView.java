package com.example.backdoor.views;

import com.example.backdoor.model.ProductView;
import com.example.backdoor.repos.ProductViewRepository;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.example.backdoor.model.ProductView;
import com.example.backdoor.model.Role;
import com.example.backdoor.repos.ProductAccessRepository;
import com.example.backdoor.repos.RoleRepository;

@PageTitle("Список продуктов")
@Route("")
@Menu(order = 0, icon = "line-awesome/svg/pencil-ruler-solid.svg")
@Uses(Icon.class)
public class HomeView extends Composite<VerticalLayout> {

    private final ProductViewRepository productViewRepository;
    private final RoleRepository roleRepository;

    public HomeView(ProductViewRepository productViewRepository, RoleRepository roleRepository) {
        this.productViewRepository = productViewRepository;
        this.roleRepository = roleRepository;
        FormLayout formLayout2Col = new FormLayout();

        Grid<ProductView> basicGrid = new Grid<>(ProductView.class);
        basicGrid.addClassName("home-view-grid-1");
        Grid<Role> basicGrid2 = new Grid<>(Role.class);
        basicGrid2.addClassName("home-view-grid-2");

        HorizontalLayout layoutRow = new HorizontalLayout();
        layoutRow.addClassName("home-view-horizontal-layout-1");
        Button buttonPrimary = new Button();
        buttonPrimary.addClassName("home-view-button-1");
        Button buttonPrimary2 = new Button();
        buttonPrimary2.addClassName("home-view-button-2");
        Button buttonPrimary3 = new Button();
        buttonPrimary3.addClassName("home-view-button-3");
        Button buttonPrimary4 = new Button();
        buttonPrimary4.addClassName("home-view-button-4");
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        layoutRow2.addClassName("home-view-horizontal-layout-2");
        Button buttonPrimary5 = new Button();
        buttonPrimary5.addClassName("home-view-button-5");
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        formLayout2Col.setWidth("100%");
        H2 header = new H2("Список продуктов");
        H2 grid1Header = new H2("Список ролей");
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

        formLayout2Col.add(header, grid1Header, basicGrid, basicGrid2, layoutRow);

        layoutRow.add(buttonPrimary);
        layoutRow.add(buttonPrimary2);
        layoutRow.add(buttonPrimary3);
        layoutRow.add(buttonPrimary4);
        formLayout2Col.add(layoutRow2);
        layoutRow2.add(buttonPrimary5);

        // Добавление обработчика событий для кнопки "Редактирование"
        buttonPrimary4.addClickListener(event -> {
            ProductView selectedItem = basicGrid.asSingleSelect().getValue();
            if (selectedItem != null) {
                showEditDialog(selectedItem);
            } else {
                System.out.println("Ничего не выбрано");
            }
        });
        buttonPrimary3.addClickListener(event -> {  UI.getCurrent().navigate("param"); });
        buttonPrimary2.addClickListener(event -> {  UI.getCurrent().navigate("op"); });
    }

    private void showEditDialog(ProductView propertyValue) {
        Dialog dialog = new Dialog();
        dialog.setWidth("400px");
        dialog.setHeight("300px");

        VerticalLayout dialogLayout = new VerticalLayout();
        dialogLayout.setPadding(false);
        dialogLayout.setSpacing(false);
        dialogLayout.getStyle().set("padding", "var(--lumo-space-m)");

        TextField nameField = new TextField("Name");
        nameField.setValue(propertyValue.getProduct().getName());
        TextField valueField = new TextField("Value");
//        valueField.setValue(propertyValue.getValue());

//        Button saveButton = new Button("Сохранить", event -> {
//            propertyValue.setValue(valueField.getValue());
//            productAccessRepository.save(propertyValue);
//            dialog.close();
//        });
//        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
//
//        Button cancelButton = new Button("Отмена", event -> dialog.close());
//
//        HorizontalLayout buttonLayout = new HorizontalLayout(saveButton, cancelButton);
//        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);
//
//        dialogLayout.add(nameField, valueField, buttonLayout);
//        dialog.add(dialogLayout);
//        dialog.open();
    }

    private void setGridSampleData_product(Grid grid) {
        grid.setItems(productViewRepository.findAll());
    }

    private void setGridSampleData_roles(Grid grid) {
        grid.setItems(roleRepository.findAll());
    }
}
