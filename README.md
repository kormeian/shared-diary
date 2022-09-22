# 공유일기 서비스

본 문서는 공유일기 서비스 프로젝트의 요구사항을 정리한 문서입니다.

### 프로젝트의 목적

본 프로젝트를 통해 모든 유저들은 가족, 친구, 연인과 함께 일기를 공유할 수 있다.

### 프로젝트 구조

> 구조 이미지 추가 예정

### 사용 기술스택

- SpringBoot
- Java
- MySQL
- Jpa

### 프로젝트의 기능

**회원가입과 로그인**

- 유저는 회원가입을 할 수 있다
    - 회원가입시 이메일, ID, 비밀번호, 핸드폰 번호, 닉네임 정보가 필요하다
    - 회원가입시 이미 회원가입된 이메일, 햅드폰 번호로 회원가입을 시도하면 에러를 발생한다
    - ID, 닉네임 정보는 중복 될 수 없다.
- 유저는 회원가입의 정보를 이용하여 로그인을 할수 있다
    - 로그인시 회원가입한적 없는 ID를 이용하여 로그인을 시도하면 에러가 발생한다
    - 로그인시 비밀번호가 일치하지 않는다면 에러가 발생한다.

**그룹 생성과 초대**

- 유저는 일기를 공유할 그룹을 만들 수 있다.
    - 그룹 이름 정보가 필요하다.
    - 그룸 이름은 중복 될 수 없다.
- 가입된 다른 유저를 초대할 수 있다.
    - 다른 유저의 핸드폰 번호 혹은 아이디 정보로 초대할 수 있다.

**일기 목록**

- 일기 목록은 그룹에 초대된 유저만 볼 수 있다
    - 유저가 로그인하지 않았다면 에러를 발생한다
- 모든 유저의 일기를 목록에서 볼 수 있다.
- 일기 목록에는 제목, 작성일, 작성자의 닉네임이 보인다

**일기 상세보기**

- 일기는 그룹에 초대된 유저만 볼 수 있다
- 일기 상세보기에서는 제목, 작성일, 작성자의 닉네임, 본문의 내용이 보인다.
- 삭제된 일기를 유저가 접근한다면 에러를 발생시킨다

**일기 작성하기**

- 게시판 글을 작성할때는 제목, 본문을 유저가 입력할 수 있다. 작성일, 작성자는 서버에서 저장한다

**일기 수정하기**

- 로그인한 유저와 글의 작성자가 일치하지 않으면 에러를 발생한다.
- 일기를 수정할때는 제목, 본문을 유저가 입력할 수 있다.

**일기 삭제하기**

- 로그인한 유저와 글의 작성자가 일치하지 않으면 에러를 발생한다.

