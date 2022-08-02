package org.zerock.domain;

import lombok.Data;

@Data
public class BoardAttachVO {

  private String uuid; //PK
  private String uploadPath; //yyyy/mm//dd
  private String fileName; // ���ε��� ���� �̸�
  private boolean fileType; // �̹��� ����
  
  private Long bno; // �Խñ� ��ȣ(FK)
  
}
