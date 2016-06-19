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
package se.sics.dozy.vod.model;

import com.google.common.primitives.Ints;
import se.sics.gvod.mngr.event.HopsTorrentUploadEvent;
import se.sics.ktoolbox.hops.managedStore.storage.util.HDFSResource;
import se.sics.ktoolbox.util.identifiable.Identifier;
import se.sics.ktoolbox.util.identifiable.basic.OverlayIdentifier;

/**
 * @author Alex Ormenisan <aaor@kth.se>
 */
public class HopsTorrentUploadJSON {

    private HDFSResourceJSON resource;
    private String user;
    private int torrentId;
    
    public HopsTorrentUploadJSON() {}

    public HDFSResourceJSON getResource() {
        return resource;
    }

    public void setResource(HDFSResourceJSON resource) {
        this.resource = resource;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getTorrentId() {
        return torrentId;
    }

    public void setTorrentId(int torrentId) {
        this.torrentId = torrentId;
    }

    
    
    public static HopsTorrentUploadEvent.Request resolveFromJSON(HopsTorrentUploadJSON req) {
        Identifier torrentId = new OverlayIdentifier(Ints.toByteArray(req.torrentId));
        HDFSResource resource = HDFSResourceJSON.resolveFromJSON(req.resource);
        return new HopsTorrentUploadEvent.Request(resource, req.user, torrentId);
    }
}
