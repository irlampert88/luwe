package com.corp.luwe.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Ivan Lampert
 */
@Entity
@Table(name = "tb_foo")
public class Foo 
	extends AbstractEntity<Long> {
	
	private static final long serialVersionUID = 1L;

	private Long id;
	private String attributeA;
	private String attributeB;
	private String attributeC;
	
	protected Foo() {
	}
	
	public Foo(String attributeA, String attributeB, String attributeC) {
		this.attributeA = attributeA;
		this.attributeB = attributeB;
		this.attributeC = attributeC;
	}

	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getAttributeA() {
		return attributeA;
	}

	public void setAttributeA(String attributeA) {
		this.attributeA = attributeA;
	}

	public String getAttributeB() {
		return attributeB;
	}

	public void setAttributeB(String attributeB) {
		this.attributeB = attributeB;
	}
	
	public String getAttributeC() {
		return attributeC;
	}
	
	public void setAttributeC(String attributeC) {
		this.attributeC = attributeC;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeA == null) ? 0 : attributeA.hashCode());
		result = prime * result + ((attributeB == null) ? 0 : attributeB.hashCode());
		result = prime * result + ((attributeC == null) ? 0 : attributeC.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Foo other = (Foo) obj;
		if (attributeA == null) {
			if (other.attributeA != null)
				return false;
		} else if (!attributeA.equals(other.attributeA))
			return false;
		if (attributeB == null) {
			if (other.attributeB != null)
				return false;
		} else if (!attributeB.equals(other.attributeB))
			return false;
		if (attributeC == null) {
			if (other.attributeC != null)
				return false;
		} else if (!attributeC.equals(other.attributeC))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Foo [id=" + id + ", attributeA=" + attributeA + ", attributeB=" + attributeB + ", attributeC="
				+ attributeC + "]";
	}

}
