package com.spring.web.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.spring.web.validation.ValidEmail;

@Entity
@Table(name="ideas")
public class Idea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="idea_name")
	private String subject;
	
	@Column(name="description")
	private String content;

	// Name of user sending Idea
	@Column(name="username")
	private String username;
	
	@NotNull
	@Column(name="score")
	private int score;

	@NotNull
	@Column(name="element1")
	private int element1;
	@NotNull
	@Column(name="element2")
	private int element2;
	@NotNull
	@Column(name="element3")
	private int element3;
	@NotNull
	@Column(name="element4")
	private int element4;
	@NotNull
	@Column(name="element5")
	private int element5;
	@NotNull
	@Column(name="element6")
	private int element6;
	@NotNull
	@Column(name="element7")
	private int element7;
	@NotNull
	@Column(name="element8")
	private int element8;
	@NotNull
	@Column(name="element9")
	private int element9;
	@NotNull
	@Column(name="element10")
	private int element10;
	@NotNull
	@Column(name="element11")
	private int element11;
	@NotNull
	@Column(name="element12")
	private int element12;
	@NotNull
	@Column(name="element13")
	private int element13;
	@NotNull
	@Column(name="element14")
	private int element14;
	@NotNull
	@Column(name="element15")
	private int element15;
	@NotNull
	@Column(name="element16")
	private int element16;
	@NotNull
	@Column(name="element17")
	private int element17;
	@NotNull
	@Column(name="element18")
	private int element18;
	@NotNull
	@Column(name="element19")
	private int element19;
	@NotNull
	@Column(name="element20")
	private int element20;
	@NotNull
	@Column(name="element21")
	private int element21;
	@NotNull
	@Column(name="element22")
	private int element22;
	@NotNull
	@Column(name="element23")
	private int element23;
	@NotNull
	@Column(name="element24")
	private int element24;
	@NotNull
	@Column(name="element25")
	private int element25;
	@NotNull
	@Column(name="element26")
	private int element26;
	@NotNull
	@Column(name="element27")
	private int element27;
	@NotNull
	@Column(name="element28")
	private int element28;
	@NotNull
	@Column(name="element29")
	private int element29;
	@NotNull
	@Column(name="element30")
	private int element30;
	@NotNull
	@Column(name="element31")
	private int element31;
	@NotNull
	@Column(name="element32")
	private int element32;
	@NotNull
	@Column(name="element33")
	private int element33;
	@NotNull
	@Column(name="element34")
	private int element34;
	@NotNull
	@Column(name="element35")
	private int element35;
	@NotNull
	@Column(name="element36")
	private int element36;
	@NotNull
	@Column(name="element37")
	private int element37;
	@NotNull
	@Column(name="element38")
	private int element38;
	@NotNull
	@Column(name="element39")
	private int element39;
	@NotNull
	@Column(name="element40")
	private int element40;
	@NotNull
	@Column(name="element41")
	private int element41;
	@NotNull
	@Column(name="element42")
	private int element42;
	@NotNull
	@Column(name="element43")
	private int element43;
	@NotNull
	@Column(name="element44")
	private int element44;
	
	public Idea() {}

	public Idea(int id, @Size(min = 5, max = 100) String subject, @Size(min = 5, max = 1000) String content,
			String username, @NotNull int total, @NotNull int element1,
			@NotNull int element2, @NotNull int element3, @NotNull int element4,
			@NotNull int element5, @NotNull int element6, @NotNull int element7,
			@NotNull int element8, @NotNull int element9, @NotNull int element10,
			@NotNull int element11, @NotNull int element12, @NotNull int element13,
			@NotNull int element14, @NotNull int element15, @NotNull int element16,
			@NotNull int element17, @NotNull int element18, @NotNull int element19,
			@NotNull int element20, @NotNull int element21, @NotNull int element22,
			@NotNull int element23, @NotNull int element24, @NotNull int element25,
			@NotNull int element26, @NotNull int element27, @NotNull int element28,
			@NotNull int element29, @NotNull int element30, @NotNull int element31,
			@NotNull int element32, @NotNull int element33, @NotNull int element34,
			@NotNull int element35, @NotNull int element36, @NotNull int element37,
			@NotNull int element38, @NotNull int element39, @NotNull int element40,
			@NotNull int element41, @NotNull int element42, @NotNull int element43,
			@NotNull int element44) {
		this.id = id;
		this.subject = subject;
		this.content = content;
		this.username = username;
		this.score = total;
		this.element1 = element1;
		this.element2 = element2;
		this.element3 = element3;
		this.element4 = element4;
		this.element5 = element5;
		this.element6 = element6;
		this.element7 = element7;
		this.element8 = element8;
		this.element9 = element9;
		this.element10 = element10;
		this.element11 = element11;
		this.element12 = element12;
		this.element13 = element13;
		this.element14 = element14;
		this.element15 = element15;
		this.element16 = element16;
		this.element17 = element17;
		this.element18 = element18;
		this.element19 = element19;
		this.element20 = element20;
		this.element21 = element21;
		this.element22 = element22;
		this.element23 = element23;
		this.element24 = element24;
		this.element25 = element25;
		this.element26 = element26;
		this.element27 = element27;
		this.element28 = element28;
		this.element29 = element29;
		this.element30 = element30;
		this.element31 = element31;
		this.element32 = element32;
		this.element33 = element33;
		this.element34 = element34;
		this.element35 = element35;
		this.element36 = element36;
		this.element37 = element37;
		this.element38 = element38;
		this.element39 = element39;
		this.element40 = element40;
		this.element41 = element41;
		this.element42 = element42;
		this.element43 = element43;
		this.element44 = element44;
	}

	public void setTotal(int total) {
		this.score = total;
	}
	
	public void setElement1(int element1) {
		this.element1 = element1;
	}

	public void setElement2(int element2) {
		this.element2 = element2;
	}

	public void setElement3(int element3) {
		this.element3 = element3;
	}

	public void setElement4(int element4) {
		this.element4 = element4;
	}

	public void setElement5(int element5) {
		this.element5 = element5;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getElement1() {
		return element1;
	}

	public int getElement2() {
		return element2;
	}

	public int getElement3() {
		return element3;
	}

	public int getElement4() {
		return element4;
	}

	public int getElement5() {
		return element5;
	}

	public int getElement6() {
		return element6;
	}

	public int getElement7() {
		return element7;
	}

	public int getElement8() {
		return element8;
	}

	public int getElement9() {
		return element9;
	}

	public int getElement10() {
		return element10;
	}

	public int getElement11() {
		return element11;
	}

	public int getElement12() {
		return element12;
	}

	public int getElement13() {
		return element13;
	}

	public int getElement14() {
		return element14;
	}

	public int getElement15() {
		return element15;
	}

	public int getElement16() {
		return element16;
	}

	public int getElement17() {
		return element17;
	}

	public int getElement18() {
		return element18;
	}

	public int getElement19() {
		return element19;
	}

	public int getElement20() {
		return element20;
	}

	public int getElement21() {
		return element21;
	}

	public int getElement22() {
		return element22;
	}

	public int getElement23() {
		return element23;
	}

	public int getElement24() {
		return element24;
	}

	public int getElement25() {
		return element25;
	}

	public int getElement26() {
		return element26;
	}

	public int getElement27() {
		return element27;
	}

	public int getElement28() {
		return element28;
	}

	public int getElement29() {
		return element29;
	}

	public int getElement30() {
		return element30;
	}

	public int getElement31() {
		return element31;
	}

	public int getElement32() {
		return element32;
	}

	public int getElement33() {
		return element33;
	}

	public int getElement34() {
		return element34;
	}

	public int getElement35() {
		return element35;
	}

	public int getElement36() {
		return element36;
	}

	public int getElement37() {
		return element37;
	}

	public int getElement38() {
		return element38;
	}

	public int getElement39() {
		return element39;
	}

	public int getElement40() {
		return element40;
	}

	public int getElement41() {
		return element41;
	}

	public int getElement42() {
		return element42;
	}

	public int getElement43() {
		return element43;
	}

	public int getElement44() {
		return element44;
	}

	public void setElement6(int element6) {
		this.element6 = element6;
	}

	public void setElement7(int element7) {
		this.element7 = element7;
	}

	public void setElement8(int element8) {
		this.element8 = element8;
	}

	public void setElement9(int element9) {
		this.element9 = element9;
	}

	public void setElement10(int element10) {
		this.element10 = element10;
	}

	public void setElement11(int element11) {
		this.element11 = element11;
	}

	public void setElement12(int element12) {
		this.element12 = element12;
	}

	public void setElement13(int element13) {
		this.element13 = element13;
	}

	public void setElement14(int element14) {
		this.element14 = element14;
	}

	public void setElement15(int element15) {
		this.element15 = element15;
	}

	public void setElement16(int element16) {
		this.element16 = element16;
	}

	public void setElement17(int element17) {
		this.element17 = element17;
	}

	public void setElement18(int element18) {
		this.element18 = element18;
	}

	public void setElement19(int element19) {
		this.element19 = element19;
	}

	public void setElement20(int element20) {
		this.element20 = element20;
	}

	public void setElement21(int element21) {
		this.element21 = element21;
	}

	public void setElement22(int element22) {
		this.element22 = element22;
	}

	public void setElement23(int element23) {
		this.element23 = element23;
	}

	public void setElement24(int element24) {
		this.element24 = element24;
	}

	public void setElement25(int element25) {
		this.element25 = element25;
	}

	public void setElement26(int element26) {
		this.element26 = element26;
	}

	public void setElement27(int element27) {
		this.element27 = element27;
	}

	public void setElement28(int element28) {
		this.element28 = element28;
	}

	public void setElement29(int element29) {
		this.element29 = element29;
	}

	public void setElement30(int element30) {
		this.element30 = element30;
	}

	public void setElement31(int element31) {
		this.element31 = element31;
	}

	public void setElement32(int element32) {
		this.element32 = element32;
	}

	public void setElement33(int element33) {
		this.element33 = element33;
	}

	public void setElement34(int element34) {
		this.element34 = element34;
	}

	public void setElement35(int element35) {
		this.element35 = element35;
	}

	public void setElement36(int element36) {
		this.element36 = element36;
	}

	public void setElement37(int element37) {
		this.element37 = element37;
	}

	public void setElement38(int element38) {
		this.element38 = element38;
	}

	public void setElement39(int element39) {
		this.element39 = element39;
	}

	public void setElement40(int element40) {
		this.element40 = element40;
	}

	public void setElement41(int element41) {
		this.element41 = element41;
	}

	public void setElement42(int element42) {
		this.element42 = element42;
	}

	public void setElement43(int element43) {
		this.element43 = element43;
	}

	public void setElement44(int element44) {
		this.element44 = element44;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Idea [id=" + id + ", subject=" + subject + ", content=" + content + ", user=" + username
				+ ", element1=" + element1 + ", element2=" + element2 + ", element3="
				+ element3 + ", element4=" + element4 + ", element5=" + element5
				+ ", element6=" + element6 + ", element7=" + element7 + ", element8="
				+ element8 + ", element9=" + element9 + ", element10=" + element10
				+ ", element11=" + element11 + ", element12=" + element12 + ", element13="
				+ element13 + ", element14=" + element14 + ", element15=" + element15
				+ ", element16=" + element16 + ", element17=" + element17 + ", element18="
				+ element18 + ", element19=" + element19 + ", element20=" + element20
				+ ", element21=" + element21 + ", element22=" + element22 + ", element23="
				+ element23 + ", element24=" + element24 + ", element25=" + element25
				+ ", element26=" + element26 + ", element27=" + element27 + ", element28="
				+ element28 + ", element29=" + element29 + ", element30=" + element30
				+ ", element31=" + element31 + ", element32=" + element32 + ", element33="
				+ element33 + ", element34=" + element34 + ", element35=" + element35
				+ ", element36=" + element36 + ", element37=" + element37 + ", element38="
				+ element38 + ", element39=" + element39 + ", element40=" + element40
				+ ", element41=" + element41 + ", element42=" + element42 + ", element43="
				+ element43 + ", element44=" + element44 + "]";
	}

	
}
