% 그레이필터
img = imread('C:\Users\Administrator\Documents\MATLAB\imageLoad\stoya.jpg');
img_gray = rgb2gray(img);
imshow(img_gray);
imwrite(img_gray, 'C:\Users\Administrator\Documents\MATLAB\imageSave\stoya_gray.jpg' );  

% 비율 8의 모자이크
img = imread('C:\Users\Administrator\Documents\MATLAB\imageLoad\stoya.jpg');
img_mosaic = imresize(imresize(img, 1/8),8);
imshow(img_mosaic);
imwrite(img_mosaic, 'C:\Users\Administrator\Documents\MATLAB\imageSave\stoya_mosaic.jpg' );

% 이진화필터
img = imread('C:\Users\Administrator\Documents\MATLAB\imageLoad\stoya.jpg');
img_gray = rgb2gray(img);
img_binary = img_gray > 128;
imshow(img_binary);
imwrite(img_binary, 'C:\Users\Administrator\Documents\MATLAB\imageSave\stoya_binary.jpg' );

% 양자화필터
img = double(rgb2gray(imread('C:\Users\Administrator\Documents\MATLAB\imageLoad\stoya.jpg')));
level = 4;
img_quantization = fix(img/(256/level));
img_quantization = 255 * img_quantization / (level - 1);
img_quantization = uint8(img_quantization);
imshow(img_quantization);
imwrite(img_quantization, 'C:\Users\Administrator\Documents\MATLAB\imageSave\stoya_quantization.jpg');

% 블러필터 (수정)
%img = imread('C:\Users\Administrator\Documents\MATLAB\imageLoad\stoyasex.png'); 
%h = fspecial('gaussian', size(img), 1.0); 
%img_blur = imfilter(img, h);
%imshow(img_blur);
%imwrite(img_blur, 'C:\Users\Administrator\Documents\MATLAB\imageSave\stoyasex_blur.png');


% 반전효과필터
img = imread('C:\Users\Administrator\Documents\MATLAB\imageLoad\stoya.jpg');
[row col] = size(img);
img_rev = 255 - img;
imshow(img_rev);
imwrite(img_rev, 'C:\Users\Administrator\Documents\MATLAB\imageSave\stoya_rev.jpg');













