package com.example.backdoor.views;

import com.example.backdoor.model.*;

import com.example.backdoor.repos.*;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("all-tables")
public class AllTablesView extends VerticalLayout {

    private final ProductRepository productRepository;
    private final PropertyRepository propertyRepository;
    private final SliceRepository sliceRepository;
    private final SliceValueRepository sliceValueRepository;
    private final PropertySliceRelationRepository propertySliceRelationRepository;
    private final PropertyValueRepository propertyValueRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;
    private final ProductAccessRepository productAccessRepository;
    private final RiskRepository riskRepository;

    @Autowired
    public AllTablesView(ProductRepository productRepository,
                         PropertyRepository propertyRepository,
                         SliceRepository sliceRepository,
                         SliceValueRepository sliceValueRepository,
                         PropertySliceRelationRepository propertySliceRelationRepository,
                         PropertyValueRepository propertyValueRepository,
                         UserRepository userRepository,
                         RoleRepository roleRepository,
                         UserRoleRepository userRoleRepository,
                         ProductAccessRepository productAccessRepository,
                         RiskRepository riskRepository) {
        this.productRepository = productRepository;
        this.propertyRepository = propertyRepository;
        this.sliceRepository = sliceRepository;
        this.sliceValueRepository = sliceValueRepository;
        this.propertySliceRelationRepository = propertySliceRelationRepository;
        this.propertyValueRepository = propertyValueRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userRoleRepository = userRoleRepository;
        this.productAccessRepository = productAccessRepository;
        this.riskRepository = riskRepository;

        add(createProductGrid());
        add(createPropertyGrid());
        add(createSliceGrid());
        add(createSliceValueGrid());
        add(createPropertySliceRelationGrid());
        add(createPropertyValueGrid());
        add(createUserGrid());
        add(createRoleGrid());
        add(createUserRoleGrid());
        add(createProductAccessGrid());
        add(createRiskGrid());
    }

    private Grid<Product> createProductGrid() {
        Grid<Product> grid = new Grid<>(Product.class);
        grid.setItems(productRepository.findAll());
        grid.addColumn(Product::getName).setHeader("Object Name");
        return grid;
    }

    private Grid<Property> createPropertyGrid() {
        Grid<Property> grid = new Grid<>(Property.class);
        grid.setItems(propertyRepository.findAll());
        grid.addColumn(Property::getName).setHeader("Property Name");
        grid.addColumn(Property::getType).setHeader("Property Type");
        grid.addColumn(Property::getScalarType).setHeader("Scalar Type");
        return grid;
    }

    private Grid<Slice> createSliceGrid() {
        Grid<Slice> grid = new Grid<>(Slice.class);
        grid.setItems(sliceRepository.findAll());
        grid.addColumn(Slice::getName).setHeader("Slice Name");
        return grid;
    }

    private Grid<SliceValue> createSliceValueGrid() {
        Grid<SliceValue> grid = new Grid<>(SliceValue.class);
        grid.setItems(sliceValueRepository.findAll());
        grid.addColumn(SliceValue::getValue).setHeader("Value");
        return grid;
    }

    private Grid<PropertySliceRelation> createPropertySliceRelationGrid() {
        Grid<PropertySliceRelation> grid = new Grid<>(PropertySliceRelation.class);
        grid.setItems(propertySliceRelationRepository.findAll());
        grid.addColumn(relation -> relation.getProperty().getName()).setHeader("Property Name");
        grid.addColumn(relation -> relation.getSlice().getName()).setHeader("Slice Name");
        return grid;
    }

    private Grid<PropertyValue> createPropertyValueGrid() {
        Grid<PropertyValue> grid = new Grid<>(PropertyValue.class);
        grid.setItems(propertyValueRepository.findAll());
        grid.addColumn(PropertyValue::getValue).setHeader("Value");
        grid.addColumn(propertyValue -> propertyValue.getRisk().getDescription()).setHeader("Risk Description");
        return grid;
    }

    private Grid<User> createUserGrid() {
        Grid<User> grid = new Grid<>(User.class);
        grid.setItems(userRepository.findAll());
        grid.addColumn(User::getUsername).setHeader("Username");
        grid.addColumn(User::getEmail).setHeader("Email");
        return grid;
    }

    private Grid<Role> createRoleGrid() {
        Grid<Role> grid = new Grid<>(Role.class);
        grid.setItems(roleRepository.findAll());
        grid.addColumn(Role::getName).setHeader("Role Name");
        return grid;
    }

    private Grid<UserRole> createUserRoleGrid() {
        Grid<UserRole> grid = new Grid<>(UserRole.class);
        grid.setItems(userRoleRepository.findAll());
        grid.addColumn(userRole -> userRole.getUser().getUsername()).setHeader("Username");
        grid.addColumn(userRole -> userRole.getRole().getName()).setHeader("Role Name");
        return grid;
    }

    private Grid<ProductAccess> createProductAccessGrid() {
        Grid<ProductAccess> grid = new Grid<>(ProductAccess.class);
        grid.setItems(productAccessRepository.findAll());
        grid.addColumn(access -> access.getUserRole().getUser().getUsername()).setHeader("Username");
        grid.addColumn(access -> access.getProduct().getName()).setHeader("Product Name");
        return grid;
    }

    private Grid<Risk> createRiskGrid() {
        Grid<Risk> grid = new Grid<>(Risk.class);
        grid.setItems(riskRepository.findAll());
        grid.addColumn(Risk::getDescription).setHeader("Risk Description");
        grid.addColumn(Risk::getLevel).setHeader("Risk Level");
        return grid;
    }
}