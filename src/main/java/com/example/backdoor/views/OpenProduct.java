package com.example.backdoor.views;

import com.example.backdoor.model.Risk;
import com.example.backdoor.repos.RoleRepository;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.router.*;

import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import com.example.backdoor.model.*;

import com.example.backdoor.repos.*;

import java.util.List;

@PageTitle("Продукт")
@Route("op")
@Menu(order = 1, icon = "line-awesome/svg/pencil-ruler-solid.svg")
@Uses(Icon.class)
public class OpenProduct extends Composite<VerticalLayout> {

    private final RiskRepository riskRepository;
    private final ProductParametrsRelationRepository sliceRelationRepository;
    private final TypeInsuredRepository typeInsuredRepository;

    private final ProductViewRepository productView;

    public   OpenProduct(RiskRepository riskRepository, ProductParametrsRelationRepository sliceRelationRepository, TypeInsuredRepository typeInsuredRepository, ProductViewRepository productView) {
        this.riskRepository = riskRepository;
        this.sliceRelationRepository = sliceRelationRepository;
        this.typeInsuredRepository = typeInsuredRepository;
        this.productView = productView;

        ProductView product = (ProductView) VaadinSession.getCurrent().getAttribute("selectedItem");
        FormLayout formLayout2Col = new FormLayout();
        Grid<ProductParametrsRelation> basicGrid = createProductParametrsRelationGrid();
        //<theme-editor-local-classname>
        basicGrid.addClassName("open-product-grid-1");
        Grid <Risk> basicGrid2 = createRiskGrid();
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
        H2 grid1Header = new H2("Риски");
        //<theme-editor-local-classname>
        grid1Header.addClassName("home-view-h2-1");
        basicGrid.setWidth("1000px");
        basicGrid.getStyle().set("flex-grow", "0");
        setGridSampleDataStrategy(basicGrid);

        basicGrid2.setWidth("250px");
        basicGrid2.getStyle().set("flex-grow", "0");
        setGridSampleDataRisk(basicGrid2);

        layoutRow.setHeightFull();
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");

        options.setText("Настройки");
        options.setWidth("min-content");
        options.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonPrimary2.setText("Открыть");
        buttonPrimary2.setWidth("min-content");
        buttonPrimary2.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonPrimary3.setText("Настройки");
        buttonPrimary3.setWidth("min-content");
        buttonPrimary3.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        addRisk.setText("Привязать");
        addRisk.setWidth("min-content");
        addRisk.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        layoutRow2.setHeightFull();
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");

        delRisk.setText("Отвязать");
        delRisk.setWidth("min-content");
        delRisk.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        options.addClickListener(event -> {  UI.getCurrent().navigate("param"); });

        List<ProductView> prod = productView.findAll();

        ComboBox allProducts = new ComboBox("Выбор продукта", prod);
        List<TypeInsured> strat = typeInsuredRepository.findAll();
        ComboBox allStrat = new ComboBox("Тип продукта", strat);
        if (product != null) {
            allProducts.setValue(product.getProduct().getName());
            allStrat.setValue(product.getTypeInsured().getType());
        }

        //<theme-editor-local-classname>
        allProducts.setOverlayClassName("open-product-combo-box-1");
        //<theme-editor-local-classname>
        allProducts.addClassName("open-product-combo-box-1");
        TextField name = new TextField();
        TextField typeStrah =  new TextField();
        name.setLabel("Наименование");
        typeStrah.setLabel("Вид страхования");

        VerticalLayout updateProd = new VerticalLayout(allProducts,name, allStrat);
        updateProd.add(name);
        getContent().add(updateProd);
        getContent().add(formLayout2Col);
        formLayout2Col.add(header, grid1Header, basicGrid, basicGrid2, layoutRow);
        layoutRow.add(options);
        formLayout2Col.add(layoutRow2);
        layoutRow2.add(addRisk,delRisk);
        HorizontalLayout hl = new HorizontalLayout();

    }
    private Grid<ProductParametrsRelation> createProductParametrsRelationGrid() {
        Grid<ProductParametrsRelation> grid = new Grid<>(ProductParametrsRelation.class);
        grid.setItems(sliceRelationRepository.findAll());
        grid.setColumns("name", "parametrs.name", "product.name");

        grid.getColumnByKey("name").setHeader("Наименование");
        grid.getColumnByKey("parametrs.name").setHeader("Параметр");
        grid.getColumnByKey("product.name").setHeader("Продукт");
        return grid;
    }
    private Grid<Risk> createRiskGrid() {
        Grid<Risk> grid = new Grid<>(Risk.class);
        grid.setItems(riskRepository.findAll());
        grid.setColumns( "name", "level", "product.name");
        grid.getColumnByKey("name").setHeader("Наименование");
        grid.getColumnByKey("level").setHeader("Уровень");
        grid.getColumnByKey("product.name").setHeader("Продукт");
        return grid;
    }
    private void setGridSampleDataStrategy(Grid grid) {
        grid.setItems(sliceRelationRepository.findAll());
    }
    private void setGridSampleDataRisk(Grid grid) {
        grid.setItems(riskRepository.findAll());
    }

}
