function zfbShow(txt, type,long)
data = importdata(txt);
data = data.textdata;
N = length(data);
y1 = [];
y2 = [];
t = [];
if (long == 1)
    date = data(1:6:N,3);
    date = str2double(date);
    date_max = max(date);
end
for i = 1: floor(N/6)
    tmp = data((i-1)*6 + 1,:);
    day = str2double(tmp{3});
    if(long == 1)
        if(day < date_max)
            continue;
        end
    end
    tmp = tmp{4};
    h = str2double(tmp(1:2));
    m = str2double(tmp(4:5));
    s = str2double(tmp(7:8));
    tmp = datenum(2015,8,day,h,m,s);
    t = [t,tmp];
    tmp = data((i-1)*6 + 4,:);
    tmp = str2double(tmp{1}(1:4));
    y1 = [y1, tmp];
    tmp = data((i-1)*6 + 5,:);
    tmp = str2double(tmp{1}(1:4));
    y2 = [y2, tmp];
end

if(type == 12)
    plot(t,y1,'r',t,y2,'b');
    legend('1 year','2 year');
elseif(type == 1)
    plot(t,y1,'r');
    legend('1 year');
elseif(type == 2)
    plot(t,y2,'b');
    legend('2 year');
else
    disp('error!! Please define type!')
end
grid on;
datetick('x');
