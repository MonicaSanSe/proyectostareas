package com.banana.proyectostareas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jdk.jfr.BooleanFlag;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tarea")
@Schema(name = "tarea", description = "Modelo tarea")
@XmlRootElement
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Min(1)
    @Schema(name = "Tarea ID", example = "1", required = false)
    private Long id;

    @Column
    @NotBlank(message = "Debe tener valor")
    @NotNull
    @Size(min = 3, max = 250)
    @Schema(name = "Descripcion tarea", example = "Tarea de desarrollo", required = true)
    private String descripcion;

    @DateTimeFormat
    @NotNull
    @Schema(name = "Fecha limite tarea", example = "2024-02-14", required = true)
    private LocalDate fechaLimite;

    @Min(0)
    @Schema(name = "Orden tarea", example = "1", required = true)
    private Integer orden;

    @NotNull
    @BooleanFlag
    @Schema(name = "Tarea completada", example = "true", required = true)
    private boolean completada;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    @Schema(name = "Proyecto tarea", example = "1", required = false)
    @JoinColumn(name = "proyecto_id")
    private Proyecto proyecto;

}
