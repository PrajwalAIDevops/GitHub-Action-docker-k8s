git add .github/
echo "enter the comment" 
read comm
git commit -m "$comm"
git push -u origin main