/*
 * Copyright 2014 Blazebit.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.blazebit.persistence.view.collections.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

/**
 * 
 * @author Christian
 */
@Entity
public class DocumentForCollections implements Serializable  {
    private Long id;
    private String name;
    private PersonForCollections owner;
    private Set<PersonForCollections> partners = new HashSet<PersonForCollections>();
    private Map<Integer, PersonForCollections> contacts = new HashMap<Integer, PersonForCollections>();
    private List<PersonForCollections> personList = new ArrayList<PersonForCollections>();

    public DocumentForCollections() {
    }

    public DocumentForCollections(String name) {
        this.name = name;
    }
    
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne(optional = false)
    public PersonForCollections getOwner() {
        return owner;
    }

    public void setOwner(PersonForCollections owner) {
        this.owner = owner;
    }

    @OneToMany(mappedBy = "partnerDocument")
    public Set<PersonForCollections> getPartners() {
        return partners;
    }

    public void setPartners(Set<PersonForCollections> partners) {
        this.partners = partners;
    }

    @OneToMany
    public Map<Integer, PersonForCollections> getContacts() {
        return contacts;
    }

    public void setContacts(Map<Integer, PersonForCollections> contacts) {
        this.contacts = contacts;
    }

    @OrderColumn(name = "position")
    @OneToMany
    @CollectionTable(name = "personlist")
    public List<PersonForCollections> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonForCollections> personList) {
        this.personList = personList;
    }    
    
}