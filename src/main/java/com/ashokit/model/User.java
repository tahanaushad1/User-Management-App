package com.ashokit.model;

import java.util.Collection;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(nullable = false, unique = true, length = 45)
	    private String email;
	    
	    @Column(nullable = false, length = 64)
	    private String password;
	    
	    @Column(name = "first_name", nullable = false, length = 20)
	    private String firstName;
	    
	    @Column(name = "last_name", nullable = false, length = 20)
	    private String lastName;
	    
	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	            name = "users_roles",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id")
	    )
	    private List<Role> roles;
	    public void setRoles(List<Role> roles) {
	        this.roles = roles;
	    }

	    
	   
	

}
