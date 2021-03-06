/*
 * Copyright (C) 2016 Swedish Institute of Computer Science (SICS) Copyright (C)
 * 2016 Royal Institute of Technology (KTH)
 *
 * Dozy is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package se.sics.dela.cli.dto.tracker;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import se.sics.dela.cli.dto.ClusterAddressDTO;
import se.sics.dela.cli.dto.DatasetDTO;

public class SearchServiceDTO {

  @XmlRootElement
  public static class Params {

    private String searchTerm;

    public Params() {
    }

    public Params(String searchTerm) {
      this.searchTerm = searchTerm;
    }

    public String getSearchTerm() {
      return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
      this.searchTerm = searchTerm;
    }
  }

  @XmlRootElement
  public static class SearchResult {

    private String sessionId;
    private int nrHits;

    public SearchResult() {
    }

    public SearchResult(String sessionId, int nrHits) {
      this.sessionId = sessionId;
      this.nrHits = nrHits;
    }

    public String getSessionId() {
      return sessionId;
    }

    public void setSessionId(String sessionId) {
      this.sessionId = sessionId;
    }

    public int getNrHits() {
      return nrHits;
    }

    public void setNrHits(int nrHits) {
      this.nrHits = nrHits;
    }
  }
  
  @XmlRootElement
  public static class Item {

    private String publicDSId;
    private DatasetDTO.Search dataset;
    private float score;

    public Item() {
    }

    public Item(String publicDSId, DatasetDTO.Search dataset, float score) {
      this.publicDSId = publicDSId;
      this.dataset = dataset;
      this.score = score;
    }

    public String getPublicDSId() {
      return publicDSId;
    }

    public void setPublicDSId(String publicDSId) {
      this.publicDSId = publicDSId;
    }

    public DatasetDTO.Search getDataset() {
      return dataset;
    }

    public void setDataset(DatasetDTO.Search dataset) {
      this.dataset = dataset;
    }

    public float getScore() {
      return score;
    }

    public void setScore(float score) {
      this.score = score;
    }
  }
  
  public static class ItemDetails {
    private DatasetDTO.Details dataset;
    private List<ClusterAddressDTO> bootstrap;

    public ItemDetails() {
    }

    public ItemDetails(DatasetDTO.Details dataset, List<ClusterAddressDTO> bootstrap) {
      this.dataset = dataset;
      this.bootstrap = bootstrap;
    }

    public DatasetDTO.Details getDataset() {
      return dataset;
    }

    public void setDataset(DatasetDTO.Details dataset) {
      this.dataset = dataset;
    }

    public List<ClusterAddressDTO> getBootstrap() {
      return bootstrap;
    }

    public void setBootstrap(List<ClusterAddressDTO> bootstrap) {
      this.bootstrap = bootstrap;
    }
  }
}

