package com.example.backdoor.views;

import com.example.backdoor.model.Property;
import com.example.backdoor.repos.PropertyRepository;
import com.example.backdoor.repos.RiskRepository;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@PageTitle("Параметры")
@Route("param")
@Menu(order = 1, icon = "line-awesome/svg/pencil-ruler-solid.svg")
@Uses(Icon.class)
public class  OpenParameters extends Composite<VerticalLayout> {
    private final PropertyRepository propertyRepository;

    public   OpenParameters(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
        FormLayout formLayout2Col = new FormLayout();
        Grid basicGrid = new Grid();
        //<theme-editor-local-classname>
        basicGrid.addClassName("open-product-grid-1");
        Grid<Property> basicGrid2 = new Grid(Property.class);
        //<theme-editor-local-classname>
        basicGrid2.addClassName("open-product-grid-2");
        HorizontalLayout layoutRow = new HorizontalLayout();
        //<theme-editor-local-classname>
        layoutRow.addClassName("home-view-horizontal-layout-1");
        Button options = new Button();
        //<theme-editor-local-classname>
        options.addClassName("home-view-button-1");
        Button buttonPrimary2 = new Button();
        //<theme-editor-local-classname>
        buttonPrimary2.addClassName("home-view-button-2");
        Button buttonPrimary3 = new Button();
        //<theme-editor-local-classname>
        buttonPrimary3.addClassName("home-view-button-3");
        Button addRisk = new Button();
        //<theme-editor-local-classname>
        addRisk.addClassName("home-view-button-4");
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        //<theme-editor-local-classname>
        layoutRow2.addClassName("home-view-horizontal-layout-2");
        Button delRisk = new Button();
        //<theme-editor-local-classname>
        delRisk.addClassName("home-view-button-5");
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        formLayout2Col.setWidth("100%");
        H2 header = new H2("Стратегии");
        H2 grid1Header = new H2("Список параметров");
        //<theme-editor-local-classname>
        grid1Header.addClassName("home-view-h2-1");
        basicGrid.setWidth("1000px");
        basicGrid.getStyle().set("flex-grow", "0");
        setGridSampleData(basicGrid);
        basicGrid2.setWidth("250px");
        basicGrid2.getStyle().set("flex-grow", "0");
        setGridSampleData(basicGrid2);
        layoutRow.setHeightFull();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        options.setText("Редактирование параметра");
        options.setWidth("min-content");
        options.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary2.setText("Открыть");
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonPrimary3.setText("Настройки");
        buttonPrimary3.setWidth("min-content");
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addRisk.setText("Редактировать параметр");
        addRisk.setWidth("min-content");
        addRisk.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        layoutRow2.setHeightFull();
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        delRisk.setText("Редактировать разрез");
        delRisk.setWidth("min-content");
        delRisk.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        List<String> prod = new ArrayList<>(Arrays.asList("ржака", "ахахахахd"));
        ComboBox allProducts = new ComboBox("Выбор продукта", prod);
        //<theme-editor-local-classname>
        allProducts.setOverlayClassName("open-parameters-combo-box-1");
        //<theme-editor-local-classname>
        allProducts.addClassName("open-parameters-combo-box-1");
        ComboBox name = new ComboBox("Выбор стратегии", prod);
        //<theme-editor-local-classname>
        name.setOverlayClassName("open-parameters-combo-box-3");
        //<theme-editor-local-classname>
        name.addClassName("open-parameters-combo-box-3");
        ComboBox typeStrah =  new ComboBox("Выбор канала продаж", prod);
        //<theme-editor-local-classname>
        typeStrah.setOverlayClassName("open-parameters-combo-box-2");
        //<theme-editor-local-classname>
        typeStrah.addClassName("open-parameters-combo-box-2");



        VerticalLayout updateProd = new VerticalLayout(allProducts,name, typeStrah);
        updateProd.setAlignItems(FlexComponent.Alignment.CENTER);
        updateProd.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        updateProd.addClassName("centered-layout");
        updateProd.add(name);

        getContent().add(formLayout2Col);
        VerticalLayout params = new VerticalLayout(grid1Header, basicGrid2, layoutRow2);
        basicGrid2.setWidthFull();
        HorizontalLayout content = new HorizontalLayout(updateProd, params);
        getContent().add(content);
        content.setWidthFull();
        layoutRow.add(options);
        layoutRow2.add(addRisk,delRisk);
        layoutRow2.setHeight("min-content");
        HorizontalLayout hl = new HorizontalLayout();
        hl.add(new H1("dsdsds"));
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(propertyRepository.findAll());

    }
}