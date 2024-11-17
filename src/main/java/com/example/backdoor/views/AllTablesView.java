package com.example.backdoor.views;

import com.example.backdoor.model.*;

import com.example.backdoor.repos.*;
import com.example.backdoor.repos.ParametrsRepository;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("all-tables")
public class AllTablesView extends VerticalLayout {

    private final ProductRepository productRepository;
    private final ParametrsRepository parametrsRepository;
    private final SliceRepository sliceRepository;
    private final ProductParametrsRelationRepository productParametrsRelationRepository;
    private final RiskRepository riskRepository;
    private final TypeInsuredRepository typeInsuredRepository;
    private final ProductViewRepository productViewRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final ProductAccessRepository productAccessRepository;

    @Autowired
    public AllTablesView(ProductRepository productRepository,
                         ParametrsRepository parametrsRepository,
                         SliceRepository sliceRepository,
                         ProductParametrsRelationRepository productParametrsRelationRepository,
                         RiskRepository riskRepository,
                         TypeInsuredRepository typeInsuredRepository,
                         ProductViewRepository productViewRepository,
                         UserRepository userRepository,
                         RoleRepository roleRepository,
                         UserRoleRepository userRoleRepository,
                         ProductAccessRepository productAccessRepository) {
        this.productRepository = productRepository;
        this.parametrsRepository = parametrsRepository;
        this.sliceRepository = sliceRepository;
        this.productParametrsRelationRepository = productParametrsRelationRepository;
        this.riskRepository = riskRepository;
        this.typeInsuredRepository = typeInsuredRepository;
        this.productViewRepository = productViewRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.productAccessRepository = productAccessRepository;

        add(createProductGrid());
        add(createParametrsGrid());
        add(createSliceGrid());
        add(createProductParametrsRelationGrid());
        add(createRiskGrid());
        add(createTypeInsuredGrid());
        add(createProductViewGrid());
        add(createUserGrid());
        add(createRoleGrid());
        add(createUserRoleGrid());
        add(createProductAccessGrid());
    }

    private Grid<Product> createProductGrid() {
        Grid<Product> grid = new Grid<>(Product.class);
        grid.setItems(productRepository.findAll());
        grid.setColumns("id", "name");
        grid.getColumnByKey("id").setHeader("ID");
        grid.getColumnByKey("name").setHeader("Наименование");
        return grid;
    }

    private Grid<Parametrs> createParametrsGrid() {
        Grid<Parametrs> grid = new Grid<>(Parametrs.class);
        grid.setItems(parametrsRepository.findAll());
        grid.setColumns("id", "name", "type", "value", "sliceCount");
        grid.getColumnByKey("id").setHeader("ID");
        grid.getColumnByKey("name").setHeader("Наименование");
        grid.getColumnByKey("type").setHeader("Тип");
        grid.getColumnByKey("value").setHeader("Значение");
        grid.getColumnByKey("sliceCount").setHeader("Количество разрезов");
        return grid;
    }

    private Grid<Slice> createSliceGrid() {
        Grid<Slice> grid = new Grid<>(Slice.class);
        grid.setItems(sliceRepository.findAll());
        grid.setColumns("id", "parametrs.name", "name", "value");
        grid.getColumnByKey("id").setHeader("ID");
        grid.getColumnByKey("parametrs.name").setHeader("Параметр");
        grid.getColumnByKey("name").setHeader("Наименование");
        grid.getColumnByKey("value").setHeader("Значение");
        return grid;
    }

    private Grid<ProductParametrsRelation> createProductParametrsRelationGrid() {
        Grid<ProductParametrsRelation> grid = new Grid<>(ProductParametrsRelation.class);
        grid.setItems(productParametrsRelationRepository.findAll());
        grid.setColumns("id","name", "parametrs.name", "product.name");
        grid.getColumnByKey("id").setHeader("#");
        grid.getColumnByKey("name").setHeader("Наименование");
        grid.getColumnByKey("parametrs.name").setHeader("Параметр");
        grid.getColumnByKey("product.name").setHeader("Продукт");
        return grid;
    }

    private Grid<Risk> createRiskGrid() {
        Grid<Risk> grid = new Grid<>(Risk.class);
        grid.setItems(riskRepository.findAll());
        grid.setColumns("id", "name", "level", "product.name");
        grid.getColumnByKey("id").setHeader("ID");
        grid.getColumnByKey("name").setHeader("Наименование");
        grid.getColumnByKey("level").setHeader("Уровень");
        grid.getColumnByKey("product.name").setHeader("Продукт");
        return grid;
    }

    private Grid<TypeInsured> createTypeInsuredGrid() {
        Grid<TypeInsured> grid = new Grid<>(TypeInsured.class);
        grid.setItems(typeInsuredRepository.findAll());
        grid.setColumns("id", "type", "product.name");
        grid.getColumnByKey("id").setHeader("ID");
        grid.getColumnByKey("type").setHeader("Тип");
        grid.getColumnByKey("product.name").setHeader("Продукт");
        return grid;
    }

    private Grid<ProductView> createProductViewGrid() {
        Grid<ProductView> grid = new Grid<>(ProductView.class);
        grid.setItems(productViewRepository.findAll());
        grid.setColumns("product.name", "risk.name", "typeInsured.type");
        grid.getColumnByKey("product.name").setHeader("Продукт");
        grid.getColumnByKey("risk.name").setHeader("Риск");
        grid.getColumnByKey("typeInsured.type").setHeader("Тип");
        return grid;
    }

    private Grid<User> createUserGrid() {
        Grid<User> grid = new Grid<>(User.class);
        grid.setItems(userRepository.findAll());
        grid.setColumns("id", "name", "email");
        grid.getColumnByKey("id").setHeader("ID");
        grid.getColumnByKey("name").setHeader("Имя");
        grid.getColumnByKey("email").setHeader("Email");
        return grid;
    }

    private Grid<Role> createRoleGrid() {
        Grid<Role> grid = new Grid<>(Role.class);
        grid.setItems(roleRepository.findAll());
        grid.setColumns("name");
        grid.getColumnByKey("name").setHeader("Наименование");
        return grid;
    }

    private Grid<UserRole> createUserRoleGrid() {
        Grid<UserRole> grid = new Grid<>(UserRole.class);
        grid.setItems(userRoleRepository.findAll());
        grid.setColumns("id", "user.name", "role.name");
        grid.getColumnByKey("id").setHeader("ID");
        grid.getColumnByKey("user.name").setHeader("Пользователь");
        grid.getColumnByKey("role.name").setHeader("Роль");
        return grid;
    }

    private Grid<ProductAccess> createProductAccessGrid() {
        Grid<ProductAccess> grid = new Grid<>(ProductAccess.class);
        grid.setItems(productAccessRepository.findAll());
        grid.setColumns("id", "userRole.user.name", "product.name");
        grid.getColumnByKey("id").setHeader("ID");
        grid.getColumnByKey("userRole.user.name").setHeader("Пользователь");
        grid.getColumnByKey("product.name").setHeader("Продукт");
        return grid;
    }
}
