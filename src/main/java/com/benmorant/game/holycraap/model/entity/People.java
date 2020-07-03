package com.benmorant.game.holycraap.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.NonNull;

@Entity
@Table(name = "people")
public class People implements Serializable {

  private static final long serialVersionUID = 2284045645181170802L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NonNull private String name;
  private int currentHp;
  private int hpMax;
  private int currentMp;
  private int mpMax;

  @OneToMany(mappedBy = "people")
  @JsonManagedReference
  private List<Item> inventory = new ArrayList<>();

  public void addItem(Item item) {
    inventory.add(item);
    item.setPeople(this);
  }

  public void removeItem(Item item) {
    inventory.remove(item);
    item.setPeople(null);
  }

  public People() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public People(@NonNull String name) {
    this.name = name;
  }

  /** Constructeur surchargé pour People (moins l'ID, auto-généré .) */
  public People(@NonNull String name, int currentHp, int hpMax, int currentMp, int mpMax) {
    this.name = name;
    this.currentHp = currentHp;
    this.hpMax = hpMax;
    this.currentMp = currentMp;
    this.mpMax = mpMax;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getCurrentHp() {
    return currentHp;
  }

  public void setCurrentHp(int currentHp) {
    this.currentHp = currentHp;
  }

  public int getHpMax() {
    return hpMax;
  }

  public void setHpMax(int hpMax) {
    this.hpMax = hpMax;
  }

  public int getCurrentMp() {
    return currentMp;
  }

  public void setCurrentMp(int currentMp) {
    this.currentMp = currentMp;
  }

  public int getMpMax() {
    return mpMax;
  }

  public void setMpMax(int mpMax) {
    this.mpMax = mpMax;
  }

  public List<Item> getInventory() {
    return inventory;
  }

  public void setInventory(List<Item> inventory) {
    this.inventory = inventory;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof People)) {
      return false;
    }
    return id != null && id.equals(((People) o).getId());
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override
  public String toString() {
    return "People{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", currentHp="
        + currentHp
        + ", hpMax="
        + hpMax
        + ", currentMp="
        + currentMp
        + ", mpMax="
        + mpMax
        + ", inventory="
        + inventory
        + '}';
  }
}
