package com.darkmode.models;

import javax.persistence.*;
	@Entity
	@Table(name = "roles")
	public class Role {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		@Enumerated(EnumType.STRING)
		@Column(length = 20)
		private RolesENUM name;
		public Role() {
		}
		public Role(RolesENUM name) {
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public RolesENUM getName() {
			return name;
		}
		public void setName(RolesENUM name) {
			this.name = name;
		}
	}

