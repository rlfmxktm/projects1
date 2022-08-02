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
    
	/* 만일 화면에 10개씩 보여준다면 시작 번호(startPage)는 무조건 끝 번호(endPage)에서 9라는 값을 뺀 값이 된다. */
    this.startPage = this.endPage - 9;

    
	/* total을 통한 endPage의 재계산 */
    int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));

    if (realEnd < this.endPage) {
      this.endPage = realEnd;
    }
    
	/* 이전(perv)의 경우는 시작 번호(startPage)가 1보다 큰 경우라면 존재하게 된다. */
    this.prev = this.startPage > 1;

	/* 다음(next)으로 가는 링크의 경우 위의 realEnd가 끝 번호 (endPage)보다 큰 경우에만 존재하게 된다. */
    this.next = this.endPage < realEnd;
  }
  
}

