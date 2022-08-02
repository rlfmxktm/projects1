package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {

  private int startPage;
  private int endPage;
  private boolean prev, next;

  private int total;
  private Criteria cri;

  public PageDTO(Criteria cri, int total) {

    this.cri = cri;
    this.total = total;

    this.endPage = (int) (Math.ceil(cri.getPageNum() / 10.0)) * 10;
    
	/* ���� ȭ�鿡 10���� �����شٸ� ���� ��ȣ(startPage)�� ������ �� ��ȣ(endPage)���� 9��� ���� �� ���� �ȴ�. */
    this.startPage = this.endPage - 9;

    
	/* total�� ���� endPage�� ���� */
    int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

    if (realEnd < this.endPage) {
      this.endPage = realEnd;
    }
    
	/* ����(perv)�� ���� ���� ��ȣ(startPage)�� 1���� ū ����� �����ϰ� �ȴ�. */
    this.prev = this.startPage > 1;

	/* ����(next)���� ���� ��ũ�� ��� ���� realEnd�� �� ��ȣ (endPage)���� ū ��쿡�� �����ϰ� �ȴ�. */
    this.next = this.endPage < realEnd;
  }
  
}

