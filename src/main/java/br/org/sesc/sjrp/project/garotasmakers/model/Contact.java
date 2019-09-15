package br.org.sesc.sjrp.project.garotasmakers.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "contacts")
public class Contact implements Serializable {

    @Id
    @SequenceGenerator(name = "contacts_seq", sequenceName = "contacts_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "Nome é obrigatório.")
    private String name;

    @Column(nullable = false, length = 150)
    @NotBlank(message = "Email é obrigatório.")
    private String email;

    @Column(nullable = false, length = 11)
    @NotBlank(message = "Telefone é obrigatório")
    private String phone;

    private boolean active;

    private LocalDateTime created;

    private LocalDateTime updated;

    @PrePersist
    private void prePersist() {
        this.active = Boolean.TRUE;
        this.created = LocalDateTime.now();
    }

    @PreUpdate
    private void preUpdate() {
        this.updated = LocalDateTime.now();
    }

    public Contact deactivate() {
        this.active = Boolean.FALSE;
        return this;
    }
}
