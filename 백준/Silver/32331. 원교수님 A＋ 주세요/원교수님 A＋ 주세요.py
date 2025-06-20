def solve():
    # 입력 받기
    N, M, X, Y = map(int, input().split())
    
    # 김한양 정보
    hanyang_info = input().split()
    hanyang_id = hanyang_info[0]
    hanyang_mid = int(hanyang_info[1])
    
    # 다른 학생들 정보
    students = []
    for _ in range(N - 1):
        student_info = input().split()
        student_id = student_info[0]
        mid_score = int(student_info[1])
        students.append((student_id, mid_score))
    
    # 2024학번 학생들만 필터링 (김한양 제외)
    eligible_students = []
    for student_id, mid_score in students:
        if student_id.startswith('2024'):
            # 기말고사 예상 점수 계산
            final_predicted = Y - (X - mid_score)  # Y - X + mid_score
            final_predicted = max(0, final_predicted)  # 0점 미만이면 0점
            total_predicted = mid_score + final_predicted
            eligible_students.append(total_predicted)
    
    # 김한양이 A+를 받을 수 있는지 확인
    # 2024학번이 아니면 A+ 불가능
    if not hanyang_id.startswith('2024'):
        print("NO")
        return
    
    # 김한양이 A+를 받기 위한 최소 점수 이진탐색
    left, right = 0, Y
    answer = -1
    
    while left <= right:
        mid = (left + right) // 2
        hanyang_total = hanyang_mid + mid
        
        # 김한양보다 점수가 높은 2024학번 학생 수 계산
        higher_count = 0
        for score in eligible_students:
            if score > hanyang_total:
                higher_count += 1
        
        # 김한양의 등수 = (김한양보다 높은 점수 학생 수) + 1
        hanyang_rank = higher_count + 1
        
        if hanyang_rank <= M:  # A+ 가능
            answer = mid
            right = mid - 1
        else:  # A+ 불가능
            left = mid + 1
    
    if answer == -1:
        print("NO")
    else:
        print("YES")
        print(answer)

solve()