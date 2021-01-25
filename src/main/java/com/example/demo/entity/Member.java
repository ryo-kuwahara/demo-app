package com.example.demo.entity;


import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "members")
@Data
public class Member {

    public Member() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotBlank(message = "名前を入力してください")
    @Size(min=2, max=30, message = "2文字以上30文字以下で入力してください。")
    @Column(name="name")
    private String name;

    @Size(min=4, max=20, message = "4文字以上20文字以下で入力してください。")
    @NotBlank(message = "パスワードを入力してください。")
    @Column(name="password")
    private String password;

    @Column(name="role_id")
    private int roleId;

    private String roleName;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @NotNull(message = "入社日を入力してください。")
    @Column(name="join_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate joinDate;

    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @NotNull(message = "性別を選択してください。")
    @Column(name="sex")
    private Integer sex;

    private String sexName;

    @Column(name="register_date")
    private LocalDateTime registerDate;

    @Column(name="modified_date")
    private LocalDateTime modifiedDate;


}
