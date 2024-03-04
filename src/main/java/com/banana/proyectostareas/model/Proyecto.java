package com.banana.proyectostareas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "proyecto")
@Schema(name = "proyecto", description = "Modelo proyecto")
@XmlRootElement
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "Proyecto ID", example = "1", required = false)
    private Long id;

    @Column
    @NotBlank(message = "Debe tener valor")
    @NotNull
    @Size(min = 3, max = 250)
    @Schema(name = "Nombre proyecto", example = "Proyecto rendimiento", required = true)
    private String nombre;

    @DateTimeFormat
    @NotNull
    @Schema(name = "Fecha creación proyecto", example = "2024-02-14", required = true)
    private LocalDate fechaCreacion;

    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "proyecto")
    @ToString.Exclude
    @JsonIgnore
    @Schema(name = "Lista tareas proyecto", example = "tarea analisis", required = false)
    private List<Tarea> tareas;
}
