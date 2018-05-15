package folders.models;

import com.sun.tools.javac.util.Context;
import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name ="owners")
public class Owner {
    private String name;
    private String username;
    private int id;
    private Set<Folder> folders;

    public Owner() {
    }

    public Owner(String name, String username) {
        this.name = name;
        this.username = username;
    }
    @Column(name ="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name ="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @OneToMany(mappedBy = "owner")
    public Set<Folder> getFolders() {
        return folders;
    }

    public void setFolders(Set<Folder> folders) {
        this.folders = folders;
    }
}
