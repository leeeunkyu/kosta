package com.kosta.j0829;

import java.io.Serializable;

/**
 * 회원클래스
 * @author 이은규
 * @version ver1.0
 * @since jdk1.4
 * @see java.lang.String
 * @see java.lang.Object#toString()
 * @see java.lang.Object#equals(Object)
 * @see java.lang.Object#hashCode()
 *
 */

public class Member implements Serializable{
	/**회원 아이디 varchar2(20)*/
	private String user_id;
	/**회원 비밀번호 varchar2(20)*/
	private String user_pwd;
	/**회원 이름 varchar2(16)*/
	private String user_name;
	/**성 char(1)*/
	private String gender;
	/**가입일 varchar2(20)*/
	private String user_signup;

	/**
	 * <pre>
	 * 회원 전체 데이터 초기화 생성자
	 * </pre>
	 * @param user_id 아이디
	 * @param user_pwd 비밀번호
	 * @param user_name 이름
	 * @param gender 성
	 * @param user_signup 가입날짜
	 */
	public Member(String user_id, String user_pwd, String user_name, String gender, String user_signup) {
		super();
		this.user_id = user_id;
		this.user_pwd = user_pwd;
		this.user_name = user_name;
		this.gender = gender;
		this.user_signup = user_signup;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		boolean result=isUser_id(user_id);
		if(result)
			this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public boolean isUser_id(String user_id) {
		if(user_id != null) {
			int length = user_id.trim().length();
			if(length>6 && length<10)
				return true;
		}
		return false;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUser_signup() {
		return user_signup;
	}
	public void setUser_signup(String user_signup) {
		this.user_signup = user_signup;
	}
//	@Override
//	public boolean equals(Object obj){
//		if ((obj!=null) && (obj instanceof Member)) {
//			Member m = (Member)obj;
//			if(m.getUser_id().equals(user_id)) {
//					System.out.println("같으값");
//					return true;
//				
//			}else {
//				System.out.println("다른값");
//			}
//		}
//	
//		return false;		
//	}
//	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public String toString() {
		return user_id + ", " + user_pwd + ", " + user_name + ", " + gender + ", " + user_signup;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	
}
