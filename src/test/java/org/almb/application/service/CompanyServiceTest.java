package org.almb.application.service;

import org.almb.adapter.in.web.dto.Company;
import org.almb.adapter.in.web.dto.CreateCompany;
import org.almb.adapter.in.web.dto.Profitability;
import org.almb.adapter.out.persistence.entity.CompanyEntity;
import org.almb.adapter.out.persistence.entity.ProfitabilityEmbeddable;
import org.almb.adapter.out.persistence.repository.CompanyRepository;
import org.almb.mapper.CompanyMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {

    @Mock
    private CompanyRepository repository;

    @Mock
    private CompanyMapper mapper;

    @InjectMocks
    private CompanyService service;

    private CompanyEntity entity;
    private Company companyDto;
    private CreateCompany createCompany;

    @BeforeEach
    void setup() {
        entity = new CompanyEntity();
        entity.setCvr("123");

        companyDto = new Company();
        companyDto.setCvr("123");

        createCompany = new CreateCompany();
        createCompany.setCvr("123");
    }

    @Test
    void shouldReturnAllCompanies() {
        when(repository.findAll()).thenReturn(List.of(entity));
        when(mapper.toDto(entity)).thenReturn(companyDto);

        List<Company> result = service.getCompanies();

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getCvr()).isEqualTo("123");

        verify(repository).findAll();
        verify(mapper).toDto(entity);
    }

    @Test
    void shouldCreateCompany() {
        when(mapper.toEntity(createCompany)).thenReturn(entity);
        when(mapper.toDto(entity)).thenReturn(companyDto);

        Company result = service.createCompany(createCompany);

        assertThat(result.getCvr()).isEqualTo("123");

        verify(repository).save(entity);
        verify(mapper).toEntity(createCompany);
        verify(mapper).toDto(entity);
    }

    @Test
    void shouldGetCompanyByCvr() {
        when(repository.findByCvr("123")).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(companyDto);

        Company result = service.getCompanyByCvr("123");

        assertThat(result.getCvr()).isEqualTo("123");

        verify(repository).findByCvr("123");
        verify(mapper).toDto(entity);
    }

    @Test
    void shouldReturnProfitability() {
        ProfitabilityEmbeddable profitabilityEntity = new ProfitabilityEmbeddable();
        Profitability profitabilityDto = new Profitability();

        entity.setProfitability(profitabilityEntity);

        when(repository.findByCvr("123")).thenReturn(Optional.of(entity));
        when(mapper.toProfitabilityDto(profitabilityEntity)).thenReturn(profitabilityDto);

        Profitability result = service.getProfitability("123");

        assertThat(result).isNotNull();

        verify(repository).findByCvr("123");
        verify(mapper).toProfitabilityDto(profitabilityEntity);
    }

    @Test
    void shouldThrowIfCompanyNotFound() {
        when(repository.findByCvr("123")).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.getCompanyByCvr("123"))
                .isInstanceOf(RuntimeException.class);

        verify(repository).findByCvr("123");
    }
}