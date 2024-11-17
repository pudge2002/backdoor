package com.example.backdoor.views;

import com.example.backdoor.model.Product;
import com.example.backdoor.model.Parametrs;

import com.example.backdoor.model.ProductParametrsRelation;
import com.example.backdoor.model.ProductView;
import com.example.backdoor.repos.ParametrsRepository;
import com.example.backdoor.repos.ProductParametrsRelationRepository;
import com.example.backdoor.repos.ProductRepository;
import com.example.backdoor.repos.TypeInsuredRepository;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.dialog.Dialog;
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
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import java.util.List;

@PageTitle("Параметры")
@Route("param")
@Menu(order = 1, icon = "line-awesome/svg/pencil-ruler-solid.svg")
@Uses(Icon.class)
public class  OpenParameters extends Composite<VerticalLayout> {
    private final ParametrsRepository parametrsRepository;
    private final ProductRepository productRepository;
    private final ProductParametrsRelationRepository productParametrsRelationRepository;
    public OpenParameters(ParametrsRepository parametrsRepository, ParametrsRepository parametrsRepository1, ProductRepository productRepository, ProductParametrsRelationRepository productParametrsRelationRepository) {

        this.parametrsRepository = parametrsRepository1;
        this.productRepository = productRepository;
        this.productParametrsRelationRepository = productParametrsRelationRepository;

        ProductView product = (ProductView) VaadinSession.getCurrent().getAttribute("selectedItem");

        FormLayout formLayout2Col = new FormLayout();
        Grid basicGrid = new Grid();
        //<theme-editor-local-classname>
        basicGrid.addClassName("open-product-grid-1");
        Grid<Parametrs> basicGrid2 =createParametrsGrid();
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

        List<Product> prod = productRepository.findAll();
        List<ProductParametrsRelation> strat = productParametrsRelationRepository.findAll();
        ComboBox allProducts = new ComboBox("Выбор продукта", prod);

        //<theme-editor-local-classname>
        allProducts.setOverlayClassName("open-parameters-combo-box-1");
        //<theme-editor-local-classname>
        allProducts.addClassName("open-parameters-combo-box-1");
        ComboBox name = new ComboBox("Выбор типа страхования", strat);
        //<theme-editor-local-classname>
        name.setOverlayClassName("open-parameters-combo-box-3");
        //<theme-editor-local-classname>
        name.addClassName("open-parameters-combo-box-3");
        ComboBox typeStrah =  new ComboBox("Выбор канала продаж", prod);
        //<theme-editor-local-classname>
        typeStrah.setOverlayClassName("open-parameters-combo-box-2");
        //<theme-editor-local-classname>
        typeStrah.addClassName("open-parameters-combo-box-2");
        if (product != null)
        {
            allProducts.setValue(product.getProduct().getName());
            name.setValue(product.getTypeInsured().getType());
        }


        VerticalLayout updateProd = new VerticalLayout(allProducts,name);
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

        addRisk.addClickListener(event -> {
            Parametrs selectedItem = (Parametrs) basicGrid2.asSingleSelect().getValue();
            System.out.println("open");
            if (selectedItem != null) {
                showEditDialog(selectedItem);
            } else {
                System.out.println("Ничего не выбрано");
            }
        });
    }

    private Grid<Parametrs> createParametrsGrid() {
        Grid<Parametrs> grid = new Grid<>(Parametrs.class);
        grid.setItems(parametrsRepository.findAll());
        grid.setColumns( "name", "type", "value", "sliceCount");

        grid.getColumnByKey("name").setHeader("Наименование");
        grid.getColumnByKey("type").setHeader("Тип");
        grid.getColumnByKey("value").setHeader("Значение");
        grid.getColumnByKey("sliceCount").setHeader("Количество разрезов");
        return grid;
    }
    private void showEditDialog(Parametrs property) {
        Dialog dialog = new Dialog();
        dialog.setWidth("400px");
        dialog.setHeight("300px");

        VerticalLayout dialogLayout = new VerticalLayout();
        dialogLayout.setPadding(false);
        dialogLayout.setSpacing(false);
        dialogLayout.getStyle().set("padding", "var(--lumo-space-m)");

        TextField nameField = new TextField("Name");
        nameField.setValue(property.getName());

        Button saveButton = new Button("Сохранить", event -> {
            property.setName(nameField.getValue());

            parametrsRepository.save(property);
            dialog.close();
        });
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button cancelButton = new Button("Отмена", event -> dialog.close());

        HorizontalLayout buttonLayout = new HorizontalLayout(saveButton, cancelButton);
        buttonLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.END);

        dialogLayout.add(nameField, buttonLayout);
        dialog.add(dialogLayout);
        dialog.open();
    }

    private void setGridSampleData(Grid grid) {
        grid.setItems(parametrsRepository.findAll());

    }
}
