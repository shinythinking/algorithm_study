-- 코드를 입력하세요
SELECT a.APNT_NO, p.PT_NAME, p.PT_NO, a.MCDP_CD, d.DR_NAME, a.APNT_YMD
from doctor d
join appointment a
on (a.mddr_id = d.dr_id)
join patient p
on (a.pt_no = p.pt_no)
where a.mcdp_cd = 'CS' and a.APNT_CNCL_YN = 'N' and date_format(a.apnt_ymd, '%Y-%m-%d') = '2022-04-13'
order by 6

