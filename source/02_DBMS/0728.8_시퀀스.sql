-- [VIII] SEQUENCE : ������ȣ ������. ��κ� �������� PK ��� �뵵
DROP SEQUENCE FRIEND_SEQ;
CREATE SEQUENCE FRIEND_SEQ
    START WITH 1 -- 1���� ����
    INCREMENT BY 1 -- 1�� ����
    MAXVALUE 9999 -- �ִ밪
    MINVALUE 1 -- �ּҰ�
    NOCACHE
    NOCYCLE;