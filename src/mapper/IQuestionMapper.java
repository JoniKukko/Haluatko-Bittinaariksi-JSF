package mapper;



import model.Question;



public interface IQuestionMapper
{
    Question getRandomQuestionByLevel(int level);
}
